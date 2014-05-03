/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.util;

import com.google.gson.Gson;
import com.una.vdc.model.IJSONConverter;

/**
 *
 * @author emilianoeloi
 */
public class GSONConverter implements IJSONConverter {

    @Override
    public String toJSON(Object object) {
        return new Gson().toJson(object);
    }
    
}
