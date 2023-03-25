/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author ravim
 */
public class NewClass extends JFrame {
    
      private int [][] maze=
            {{1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,0,0,1,1,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,1,0,0,9,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };
      
       private List<Integer> path=new ArrayList<>();
    //     private int pathIndex;
    public NewClass(){
        setTitle("Maze Solver");
        setSize(640,640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFS.searchpath(maze,1,1,path);
       System.out.println(path);

    }
    
      @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(50, 50);

        for (int r=0;r<maze.length;r++) {
            for (int c=0;c<maze[0].length;c++) {
                Color color;
                switch(maze[r][c]) {
                    case 1 : color=Color.BLACK; break;
                    case 9 : color=Color.RED; break;
                    default : color=Color.WHITE; break;

                }
                g.setColor(color);
                g.fillRect(30*c,30*r,30,30);
                g.setColor(Color.RED);
                g.drawRect(30*c,30*r,30,30);

             }
          }
        
        for(int p=0;p<path.size();p+=2){
            int pathx=path.get(p);
            int pathy=path.get(p+1);
            System.out.println("x coordinate"+pathx);
            System.out.println("y coordinate"+pathy);
            g.setColor(Color.GREEN);
            g.fillRect(pathx*30, pathy*30, 30, 30);


        } 
    }
      
public static void main(String[] args) {
         
       SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                NewClass view =new NewClass();
                view.setVisible(true);
            }

        });

    }
    
}
