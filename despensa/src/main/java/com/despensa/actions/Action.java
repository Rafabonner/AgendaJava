package com.despensa.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
     String executa(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
