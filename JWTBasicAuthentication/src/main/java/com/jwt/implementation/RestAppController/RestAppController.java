package com.jwt.implementation.RestAppController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.implementation.config.JwtGeneratorValidator;
import com.jwt.implementation.model.User;
import com.jwt.implementation.model.UserDTO;
import com.jwt.implementation.service.DefaultUserService;

@RestController
public class RestAppController {

	@Autowired
	DefaultUserService userService;

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	JwtGeneratorValidator jwtGenVal;

	@PostMapping("/registration")
	public ResponseEntity<Object> registerUser(@RequestBody UserDTO userDto) {
		User users = userService.save(userDto);
		if (users.equals(null))
			return generateRespose("Not able to save user ", HttpStatus.BAD_REQUEST, userDto);
		else
			return generateRespose("User saved successfully : " + users.getId(), HttpStatus.OK, users);
	}

	@GetMapping("/genToken")
	public String generateJwtToken(@RequestBody UserDTO userDto) throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(userDto.getUserName(), userDto.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtGenVal.generateToken(userDto.getUserName());
	}

	public ResponseEntity<Object> generateRespose(String message, HttpStatus st, Object responseobj) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("meaasge", message);
		map.put("Status", st.value());
		map.put("data", responseobj);

		return new ResponseEntity<Object>(map, st);
	}

	@GetMapping("/welcomeAdmin")
	public String welcome() {
		return "WelcomeAdmin";
	}

}
