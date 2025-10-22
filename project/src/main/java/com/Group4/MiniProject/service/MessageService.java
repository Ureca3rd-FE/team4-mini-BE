package com.Group4.MiniProject.service;

import com.Group4.MiniProject.dto.MessageRequestDto;
import com.Group4.MiniProject.entity.Ingredient;
import com.Group4.MiniProject.entity.Message;
import com.Group4.MiniProject.entity.Theme;
import com.Group4.MiniProject.entity.User;
import com.Group4.MiniProject.repository.IngredientRepository;
import com.Group4.MiniProject.repository.MessageRepository;
import com.Group4.MiniProject.repository.ThemeRepository;
import com.Group4.MiniProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor // final 필드에 대한 생성자를 자동으로 생성합니다. (의존성 주입)
public class MessageService {

    // 4개의 Repository를 모두 사용해야 하므로 의존성을 주입받습니다.
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ThemeRepository themeRepository;
    private final IngredientRepository ingredientRepository;

    /**
     * 메시지를 생성하고, 수신자에게 랜덤 재료 3개를 지급합니다.
     * 이 메소드는 2개의 DB 쓰기 작업을 하므로 @Transactional을 사용합니다.
     * @param requestDto 클라이언트로부터 받은 메시지 작성 데이터
     * @param senderNickname 메시지를 보내는 사람(로그인한 유저)의 닉네임
     */
    @Transactional
    public void createMessage(MessageRequestDto requestDto, String senderNickname) {


        User receiver = userRepository.findByNickname(requestDto.getReceivedNickname()).orElseThrow(
                () -> new IllegalArgumentException("해당 닉네임의 사용자를 찾을 수 없습니다.")
        );

        Theme theme = themeRepository.findById(requestDto.getThemeId()).orElseThrow(
                () -> new IllegalArgumentException("해당 ID의 테마를 찾을 수 없습니다.")
        );


        Message message = Message.builder()
                .message(requestDto.getMessage())
                .nickname(senderNickname)           // 보낸 사람 닉네임 설정
                .isOpen(false)                      // 최초 상태는 항상 '안 읽음'
                .receivedUser(receiver)             // 연관관계 설정 (수신자)
                .theme(theme)                       // 연관관계 설정 (테마)
                .build();

        messageRepository.save(message);            // DB에 메시지 INSERT


        Ingredient ingredient = ingredientRepository.findByUserId(receiver.getId()).orElseThrow(
                () -> new IllegalArgumentException("사용자의 재료 정보를 찾을 수 없습니다.")
        );

        List<String> ingredientNames = Arrays.asList("snow", "rock", "carrot", "branch", "neck");
        Random random = new Random();

        for (int i = 0; i < 3; i++) { // 3번 반복
            String randomIngredient = ingredientNames.get(random.nextInt(ingredientNames.size())); // 5개 중 1개 랜덤 선택
            switch (randomIngredient) {
                case "snow":
                    ingredient.setSnow(ingredient.getSnow() + 1);
                    break;
                case "rock":
                    ingredient.setRock(ingredient.getRock() + 1);
                    break;
                case "carrot":
                    ingredient.setCarrot(ingredient.getCarrot() + 1);
                    break;
                case "branch":
                    ingredient.setBranch(ingredient.getBranch() + 1);
                    break;
                case "neck":
                    ingredient.setNeck(ingredient.getNeck() + 1);
                    break;
            }
        }

        ingredientRepository.save(ingredient);
    }
}
