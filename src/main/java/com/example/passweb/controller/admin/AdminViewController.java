package com.example.passweb.controller.admin;

import com.example.passweb.dto.pass.BulkPassRequest;
import com.example.passweb.service.pack.PackageService;
import com.example.passweb.service.pass.BulkPassService;
import com.example.passweb.service.statistics.StatisticsService;
import com.example.passweb.service.user.UserGroupMappingService;
import com.example.passweb.util.LocalDateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminViewController {

    private final BulkPassService bulkPassService;
    private final PackageService packageService;
    private final UserGroupMappingService userGroupMappingService;
    private final StatisticsService statisticsService;

    @GetMapping
    public ModelAndView home(ModelAndView modelAndView, @RequestParam("to") String toString){
        LocalDateTime to = LocalDateTimeUtils.parseDate(toString);

         modelAndView.addObject("chartData",statisticsService.makeChatData(to));
         modelAndView.setViewName("admin/index");
         return modelAndView;
    }

    @GetMapping("/bulk-pass")
    public ModelAndView registerBulkPass(ModelAndView modelAndView){
        modelAndView.addObject("bulkPasses",bulkPassService.getAllBulkPasses());
        modelAndView.addObject("packages",packageService.getAllPackages());
        modelAndView.addObject("userGroupIds",userGroupMappingService.getAllUserGroupIds());
        modelAndView.addObject("request",new BulkPassRequest());
        modelAndView.setViewName("admin/bulk-pass");
        return modelAndView;
    }

    @PostMapping("/bulk-pass")
    public String addBulkPass(@ModelAttribute("request") BulkPassRequest request, Model model){
        bulkPassService.addBulkPass(request);
        return "redirect:/admin/bulk-pass";
    }



}
