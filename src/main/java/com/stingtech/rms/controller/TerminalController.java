package com.stingtech.rms.controller;

import com.stingtech.rms.entity.Terminal;
import com.stingtech.rms.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TerminalController {

    private final TerminalService terminalService;

    @Autowired
    public TerminalController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @GetMapping("/terminals")
    public String getTerminalsList(Model model){
        model.addAttribute("terminals", terminalService.getAllTerminals());
        return "terminals";
    }
    @GetMapping("terminal/new")
    public String createTerminalForm(Model model){
        /*
        This method creates an object used to populate the form, by using fields from the entity class
         */
        Terminal terminal = new Terminal();
        model.addAttribute("terminal", terminal);
        return "create-terminal";
    }

    @PostMapping("terminals")
    public String addTerminal(@ModelAttribute("terminal") Terminal terminal){
        terminalService.saveTerminal(terminal);
        return "redirect:/terminals";
    }

    @GetMapping("terminals/search")
   public String searchTerminal(Model model, Terminal terminal){
        Terminal exisitingTerminal = terminalService.findTerminal(terminal.getTerminalId());
        model.addAttribute("terminal", exisitingTerminal);
        return "terminals";
   }

   @GetMapping("terminals/edit/{id}")
   public String editTerminalForm(){
        return "edit-terminal";
   }

   public String deleteTerminal(){
        return null;
   }
}
