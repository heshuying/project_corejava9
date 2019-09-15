package com.eyesfree.corejava.v1.v1ch09.calculator;

import javax.swing.*;

/**
 * A frame with a calculator panel.
 */
public class CalculatorFrame extends JFrame
{
   public CalculatorFrame()
   {
      add(new CalculatorPanel());
      pack();
   }
}
