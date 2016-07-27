package com.example.dto;

import com.example.domain.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * User Output DTO.
 */
@Data
@Setter
@Getter
public class UserDto {

    private String id;

    private String name;

    private String nickname;

    private String birthday;

    public static UserDto create(Long id, String name, String nickname, String birthday) {
        UserDto userDto = new UserDto();

        userDto.setId(id.toString());
        userDto.setName(name);
        userDto.setNickname(nickname);
        userDto.setBirthday(birthday);

        return userDto;
    }

    public static UserDto create(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId(String.valueOf(user.getId()));
        userDto.setName(user.getName());
        userDto.setNickname(user.getNickname());
        userDto.setBirthday(user.getBirthday());

        return userDto;
    }
}
