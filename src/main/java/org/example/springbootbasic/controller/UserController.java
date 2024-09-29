package org.example.springbootbasic.controller;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.example.springbootbasic.dto.MemberCreateRequestDTO;
import org.example.springbootbasic.dto.MemberDeleteRequestDTO;
import org.example.springbootbasic.dto.MemberResponseDTO;
import org.example.springbootbasic.model.User;
import org.example.springbootbasic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String findAllUsers(Model model){
        List<MemberResponseDTO> users = userService.findAll();
        System.out.println("users.size()" + users.size());
        model.addAttribute("users",users);
        return "user_list";
    }

    @GetMapping("/register")
    public String registerForm(){
        return "sign_up";
    }

    @PostMapping("/register")
    public String createUser(@RequestBody MemberCreateRequestDTO request) {
        userService.createUser( request.toUser() );
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        MemberResponseDTO user = userService.findById(id);
        model.addAttribute("user",user);
        return "user_update";
    }

    @PostMapping("/update")
    public String updateUser(){
        return "redirect:/users";
    }

//    쿼리스트링 방식
//    @GetMapping("/update")
//    public String updateForm(@RequestParam("id") Long id, Model model){
//        System.out.println("id : " + id);
//        return "user_update";
//    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id, Model model){
        MemberResponseDTO user = userService.findById(id);
        model.addAttribute("user",user);
        return "user_delete";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestBody MemberDeleteRequestDTO request, RedirectAttributes redirectAttributes){
        boolean checkValidation = userService.checkValidation(request.getId(), request.getPassword());
        if(!checkValidation){
            redirectAttributes.addFlashAttribute("errorMessage", "입력된 정보가 일치하지 않습니다.");
            return "redirect:/delete/{id}";
        } else{
            userService.deleteUser(request.toUser());
            return "redirect:/users";
        }
    }


}
