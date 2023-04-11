package com.iftm.exercicio02;

import com.iftm.exercicio02.data.vo.UserVO;
import com.iftm.exercicio02.mapper.DozerMapper;
import com.iftm.exercicio02.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio02Application {

	public static void main(String[] args) {
		SpringApplication.run(Exercicio02Application.class, args);

		//User user = new User();
		//UserVO userVO = DozerMapper.parseObject(user, UserVO.class);
	}

}
