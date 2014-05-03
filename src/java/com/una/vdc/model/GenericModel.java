/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.una.vdc.model;

import java.util.List;

/**
 *
 * @author emilianoeloi
 */
public abstract class GenericModel<T> implements Cloneable{
    public abstract String toJSON(IJSONConverter converter) throws CloneNotSupportedException;
}
