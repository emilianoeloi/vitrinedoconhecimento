/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.bo;

import com.una.vdc.model.IJSONConverter;
import java.util.List;

/**
 *
 * @author emilianoeloi
 */
public abstract class GenericController<T> {

    public abstract String listToJSON(IJSONConverter converter,  List<T> list) throws CloneNotSupportedException;
}
