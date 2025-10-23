package com.Group4.MiniProject.Message.service;

import com.Group4.MiniProject.Message.dto.MessageRequestDto;
import com.Group4.MiniProject.Message.dto.MessageResponseDto;
import com.Group4.MiniProject.Ingredient.entity.Ingredient;
import com.Group4.MiniProject.Message.entity.Message;
import com.Group4.MiniProject.Theme.entity.Theme;
import com.Group4.MiniProject.User.entity.User;
import com.Group4.MiniProject.Ingredient.repository.IngredientRepository;
import com.Group4.MiniProject.Message.repository.MessageRepository;
import com.Group4.MiniProject.Theme.repository.ThemeRepository;
import com.Group4.MiniProject.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ThemeRepository themeRepository;
    private final IngredientRepository ingredientRepository;

    // 메시지 개별 조회
    public MessageResponseDto getMessageDetail(UUID messageId) {
        Message message = messageRepository.findByUuid(messageId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "해당 메시지를 찾을 수 없습니다."
                ));

        // DTO로 변환하여 반환
        return new MessageResponseDto(message);

        // 빌더 패턴이 null 값으로 보내주게 되어 주석 차리
//        return MessageResponseDto.builder()
//                .message(message.getMessage())
//                .nickname(message.getNickname())
//                .themeId(message.getTheme().getThemeId())
//                .build();
    }

    // 메시지 작성 및 재료 지급
    /**
    * 메시지를 생성하고, 수신자에게 랜덤 재료 3개를 지급합니다.
    * 이 메소드는 2개의 DB 쓰기 작업을 하므로 @Transactional을 사용합니다.
    * @param requestDto 클라이언트로부터 받은 메시지 작성 데이터
    * @param senderNickname 메시지를 보내는 사람(로그인한 유저)의 닉네임
    */
    @Transactional
    public void createMessage(MessageRequestDto requestDto, String senderNickname) {

        // 수신자 조회
        User receiver = userRepository.findByNickname(requestDto.getReceivedNickname())
                .orElseThrow(() -> new IllegalArgumentException("해당 닉네임의 사용자를 찾을 수 없습니다."));

        // 테마 조회
        Theme theme = themeRepository.findById(requestDto.getThemeId())
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 테마를 찾을 수 없습니다."));

        // 메시지 생성
        Message message = Message.builder()
                .message(requestDto.getMessage())
                .nickname(senderNickname)
                .isOpen(false)
                .receivedUser(receiver)
                .theme(theme)
                .build();

        messageRepository.save(message);

        // 수신자 재료 조회
        Ingredient ingredient = ingredientRepository.findByUserId(receiver.getId())
                .orElseThrow(() -> new IllegalArgumentException("사용자의 재료 정보를 찾을 수 없습니다."));

        // 랜덤 3개 재료 지급
        List<String> ingredientNames = Arrays.asList("snow", "rock", "carrot", "branch", "muffler");
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            String randomIngredient = ingredientNames.get(random.nextInt(ingredientNames.size()));
            switch (randomIngredient) {
                case "snow" -> ingredient.setSnow(ingredient.getSnow() + 1);
                case "rock" -> ingredient.setRock(ingredient.getRock() + 1);
                case "carrot" -> ingredient.setCarrot(ingredient.getCarrot() + 1);
                case "branch" -> ingredient.setBranch(ingredient.getBranch() + 1);
                case "muffler" -> ingredient.setNeck(ingredient.getNeck() + 1);
            }
        }

        ingredientRepository.save(ingredient);
    }
}
