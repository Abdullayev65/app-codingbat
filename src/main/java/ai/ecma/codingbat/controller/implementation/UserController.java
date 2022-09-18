package ai.ecma.codingbat.controller.implementation;

import ai.ecma.codingbat.entity.User;
import ai.ecma.codingbat.payload.ApiResult;
import ai.ecma.codingbat.payload.UserDTO;
import ai.ecma.codingbat.service.implemention.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestTemplate restTemplate;


    @DeleteMapping("/{id}")
    public ApiResult<Boolean> delete(@PathVariable UUID id) {
        return userService.delete(id);
    }


    @PutMapping("/edit")
    @PreAuthorize(value = "hasAnyAuthority('EDIT_ROLE')")
    public ApiResult<Boolean> editRole(@RequestBody UserDTO userDTO) {
        return userService.editRole(userDTO);
    }

//    @GetMapping("/test")
//    public ApiResult<?> getBla() {
//
//        CurrencyDTO[] forObject = restTemplate.getForObject(
//                "https://cbu.uz/oz/arkhiv-kursov-valyut/json/",
//                CurrencyDTO[].class);
//
//
//        SignDTO signDTO = new SignDTO("admin@codingbat.com", "root123");
//        ResponseEntity<ApiResult<TokenDTO>> signExchange = restTemplate.exchange(
//                "http://localhost:8090/api/auth/sign-in",
//                HttpMethod.POST,
//                new HttpEntity<>(signDTO),
//                new ParameterizedTypeReference<>() {
//                }
//        );
//        TokenDTO tokenDTO = signExchange.getBody().getData();
//
//        AddLanguageDTO addLanguageDTO = new AddLanguageDTO("JAVA");
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization", tokenDTO.getTokenType() + tokenDTO.getAccessToken());
//
//        HttpEntity<AddLanguageDTO> body = new HttpEntity<>(addLanguageDTO,
//                httpHeaders
//        );
////        ResponseEntity<ApiResult> addLanguage = restTemplate.postForEntity(
////                "http://localhost:8090/api/language/add",
////                body,
////                ApiResult.class
////        );
////        ApiResult apiResult = restTemplate.postForObject(
////                "http://localhost:8090/api/language/add",
////                body,
////                ApiResult.class
////        );
//
//        ResponseEntity<ApiResult<LanguageDTO>> exchange = restTemplate.exchange(
//                "http://localhost:8090/api/language/add",
//                HttpMethod.POST,
//                body,
//                new ParameterizedTypeReference<>() {
//                }
//        );
//
//
////        ResponseEntity<CurrencyDTO[]> forEntity = restTemplate.getForEntity(
////                "https://cbu.uz/oz/arkhiv-kursov-valyut/json/",
////                CurrencyDTO[].class);
//
////        CurrencyDTO[] body = forEntity.getBody();
//
//        return ApiResult.successResponse(exchange.getBody().getData());
//    }
}
