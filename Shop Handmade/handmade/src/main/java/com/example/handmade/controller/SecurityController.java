package com.example.handmade.controller;

import com.example.handmade.model.LoginRequest;
import com.example.handmade.security_authentication.jwt.JwtUtility;
import com.example.handmade.security_authentication.payload.reponse.JwtResponse;
import com.example.handmade.security_authentication.service.AccountDetails;
import com.example.handmade.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api/public")
@CrossOrigin
public class SecurityController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;



    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        //Xác thực
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());
        AccountDetails userDetails = (AccountDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                new JwtResponse(
                        jwt,
                        userDetails.getUsername(),
                        accountService.findAccountByEmployeeEmail(loginRequest.getUsername()).getName(),
                        roles)
        );
    }
}
