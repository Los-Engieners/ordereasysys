package org.ordereasy.controllers;

import org.ordereasy.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdrController {
    @Autowired
    private IRoleService roleService;
}
