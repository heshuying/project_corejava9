package com.eyesfree.corejava.v1.v1ch09.colorChooser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * A panel with buttons to pop up three types of color choosers
 */
public class ColorChooserPanel extends JPanel
{
   public ColorChooserPanel()
   {
      JButton modalButton = new JButton("Modal");
      modalButton.addActionListener(new ModalListener());
      add(modalButton);

      JButton modelessButton = new JButton("Modeless");
      modelessButton.addActionListener(new ModelessListener());
      add(modelessButton);

      JButton immediateButton = new JButton("Immediate");
      immediateButton.addActionListener(new ImmediateListener());
      add(immediateButton);
   }

   /**
    * This listener pops up a modal color chooser
    */
   private class ModalListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         Color defaultColor = getBackground();
         Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Set background",
               defaultColor);
         if (selected != null) setBackground(selected);
      }
   }

   /**
    * This listener pops up a modeless color chooser. The panel color is changed when the user
    * clicks the OK button.
    */
   private class ModelessListener implements ActionListener
   {
      private JDialog dialog;
      private JColorChooser chooser;

      public ModelessListener()
      {
         chooser = new JColorChooser();
         dialog = JColorChooser.createDialog(ColorChooserPanel.this, "Background Color",
               false /* not modal */, chooser, 
               new ActionListener() // OK button listener               
                  {
                     public void actionPerformed(ActionEvent event)
                     {
                        setBackground(chooser.getColor());
                     }
                  }, null /* no Cancel button listener */);
      }

      public void actionPerformed(ActionEvent event)
      {
         chooser.setColor(getBackground());
         dialog.setVisible(true);
      }
   }

   /**
    * This listener pops up a modeless color chooser. The panel color is changed immediately when
    * the user picks a new color.
    */
   private class ImmediateListener implements ActionListener
   {
      private JDialog dialog;
      private JColorChooser chooser;

      public ImmediateListener()
      {
         chooser = new JColorChooser();
         chooser.getSelectionModel().addChangeListener(new ChangeListener()
            {
               public void stateChanged(ChangeEvent event)
               {
                  setBackground(chooser.getColor());
               }
            });

         dialog = new JDialog((Frame) null, false /* not modal */);
         dialog.add(chooser);
         dialog.pack();
      }

      public void actionPerformed(ActionEvent event)
      {
         chooser.setColor(getBackground());
         dialog.setVisible(true);
      }
   }
}
