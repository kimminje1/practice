package com.wing.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wing.member.controller.MemberController;

@RequestMapping("/admin")
@Controller
public class AdminController {
  private Logger log = LoggerFactory.getLogger(MemberController.class);
  private final String logTitleMsg = "==AdminController==";
}
