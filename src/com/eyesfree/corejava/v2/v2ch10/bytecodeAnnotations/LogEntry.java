package com.eyesfree.corejava.v2.v2ch10.bytecodeAnnotations;

import java.lang.annotation.*;

/**
 * @version 1.00 2004-08-17
 * @author Cay Horstmann
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogEntry
{
   String logger();
}
