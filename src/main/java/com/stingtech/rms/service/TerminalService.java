package com.stingtech.rms.service;

import com.stingtech.rms.entity.Terminal;
import com.stingtech.rms.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TerminalService {

    private final TerminalRepository terminalRepository;

    @Autowired
    public TerminalService(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    public List<Terminal> getAllTerminals() {
        return terminalRepository.findAll();
    }

    public void saveTerminal(Terminal terminal) {
        terminalRepository.save(terminal);
    }

    public Terminal findTerminal(long terminalId) throws NoSuchElementException {
        Optional<Terminal> terminalOptional = terminalRepository.findById(terminalId);
        Terminal existingTerminal = terminalOptional.get();
        return existingTerminal;

        //handle NoSuchElement exception when terminal not found
    }
}
