package com.wing.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {

	private Logger log = LoggerFactory.getLogger(BoardController.class);
	private final String logTitleMsg = "==BoardController==";
	
}
