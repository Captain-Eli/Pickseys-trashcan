public class Examples {
  
  public static void t1() {
    StdDraw.setCanvasSize(1000,800);
    StdDraw.setXscale(0,999);
    StdDraw.setYscale(0,799);
    StdDraw.clear(StdDraw.BLACK);
    drawTree(400, 100, 300, 270);
  }
  
  public static void drawTree(double x0, double y0, double len, double angle) {
    if(len > 4) {
      double x1 = x0 + len * Math.cos((angle/360.0)*2*3.14159);
      double y1 = y0 - len * Math.sin((angle/360.0)*2*3.14159);
      
      StdDraw.setPenColor(Math.random(),Math.random(),Math.random());
      StdDraw.line(x0, y0, x1, y1);
      //drawTree(x1, y1, len * 0.55, angle + 70); //==> .65, +.05
      //drawTree(x1, y1, len * 0.55, angle - 70);
      drawTree(x1, y1, len * (Math.random()*.3+.5), angle + myRand(10,80)); //==> .65, +.05
      drawTree(x1, y1, len * (Math.random()*.2+.3), angle+myRand(1,80)-40);
      drawTree(x1, y1, len * (Math.random()*.3+.5), angle -myRand(10,80));
      //drawTree(x1, y1, len * 0.75, angle + 30);
      //drawTree(x1, y1, len * 0.66, angle - 50);
      
    }
  }
  public static void t2() {
    int l=0;
    StdDraw.setCanvasSize(800,800);
    StdDraw.setXscale(0,9);
    StdDraw.setYscale(0,9);
    StdDraw.setPenRadius(1/6.6);
    StdDraw.clear(StdDraw.BLACK);
    
    for(l=0;l<2000;l=l+1) {
      StdDraw.setPenColor(Math.random(),Math.random(),Math.random());
      StdDraw.point(myRand(0,9),myRand(0,9));
    }
  }
  
  public static void t3() {
    int l=0,x=0,y=0,nx=0,ny=0;
    double saver=0.0, saveg=0.0, saveb=0.0;
    StdDraw.setCanvasSize(800,800);
    StdDraw.setXscale(0,9);
    StdDraw.setYscale(0,9);
    StdDraw.setPenRadius(1/6.6);
    StdDraw.clear(StdDraw.BLACK);
    double[][] mapr = new double[10][10];
    double[][] mapg = new double[10][10];
    double[][] mapb = new double[10][10];
    
    for(l=0;l<200;l=l+1) {
      x = myRand(0,9);
      y = myRand(0,9);
      mapr[x][y] = Math.random();
      mapg[x][y] = Math.random();
      mapb[x][y] = Math.random();
      StdDraw.setPenColor(mapr[x][y],mapg[x][y],mapb[x][y]);
      StdDraw.point(x,y);
    }
    
    for(l=0;l<2000;l=l+1) {
      nx=-1;ny=-1;x=0;y=0;
      while (mapr[x][y]!=0) {
        x = myRand(0,9);
        y = myRand(0,9);
      }
      while (nx<0 || nx>9 || ny<0 || ny>9) {
        if (Math.random()<.5) {
          nx=x+myRand(0,2)-1;
          ny=y;
        }
        else {
          ny=y+myRand(0,2)-1;
          nx=x;
        }
      }
      mapr[x][y] = mapr[nx][ny];
      mapg[x][y] = mapg[nx][ny];
      mapb[x][y] = mapb[nx][ny];
      StdDraw.setPenColor(mapr[x][y],mapg[x][y],mapb[x][y]);
      StdDraw.point(x,y);
      mapr[nx][ny] = 0;
      mapg[nx][ny] = 0;
      mapb[nx][ny] = 0;
      StdDraw.setPenColor(0,0,0);
      StdDraw.point(nx,ny);
    }
  }
  
  public static void t4() {
    int l=0,score=0;
    char c ='i';
    int x=40,y=70,xc=0,yc=-1;
    int time=50; // speed of game
    int bx=0,by=0;
    boolean[][] map = new boolean[80][80];
    StdDraw.setCanvasSize(800,800);
    StdDraw.setXscale(0,79);
    StdDraw.setYscale(0,79);
    StdDraw.setPenRadius(1/80.0);
    boolean flag=true;
    StdDraw.clear(StdDraw.BLACK);
    StdDraw.setPenColor(StdDraw.WHITE);
    for (l=0;l<80;l++) {
      plot(0,l,map);
      plot(l,0,map);
      plot(79,l,map);
      plot(l,79,map);
    }   
    
    while (flag)  {
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.text(4,75,score+"");
      StdDraw.setPenColor(StdDraw.WHITE);
      score++;
      StdDraw.text(4,75,score+"");
      StdDraw.show(time);
      if (StdDraw.hasNextKeyTyped()) {
        c = StdDraw.nextKeyTyped();
        if (c=='i') {yc=1;xc=0;}
        if (c=='m') {yc=-1;xc=0;}
        if (c=='j') {xc=-1;yc=0;}
        if (c=='k') {xc=1;yc=0;}
      }
      StdDraw.setPenColor(StdDraw.BLUE);
      plot(x,y,map);
      x += xc;
      y += yc;
      if (map[x][y]) {flag=false;}
      
      if (score%20==0) {
        bx = myRand(1,38)*2;
        by = myRand(1,38)*2;
        if ((Math.abs(bx-x)+Math.abs(by-y))>7) {
          StdDraw.setPenColor(Math.random()*.8+.2,
                              Math.random()*.8+.2,Math.random()*.8+.2);
          plot(bx,by,map);
          plot(bx+1,by,map);
          plot(bx,by+1,map);
          plot(bx+1,by+1,map);
        }
      }
      if ((score%50)==0) time = time-2; // speed up game
    }
    System.out.println(score);
  }
  
  public static void plot(int x, int y, boolean[][] map) {
    StdDraw.point(x,y);
    map[x][y]=true;
  }
  
  public static void t5() {
    StdDraw.setCanvasSize(800,800);
    StdDraw.setXscale(0, 1.0);
    StdDraw.setYscale(0, 1.0);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.filledSquare(.5,.5,5);
    for (int i = 1;i<10000;i++) {
      StdDraw.setPenColor(Math.random(),Math.random(),Math.random());
      StdDraw.line(Math.random(),Math.random(),Math.random(),Math.random());
    }
  }
  
  public static void t6() {
    StdDraw.setCanvasSize(800,800);
    StdDraw.setXscale(0,799);
    StdDraw.setYscale(0,799);
    StdDraw.clear(StdDraw.BLACK);
    drawTree1(400, 200, 300, 270);
  }
  
  public static void drawTree1(double x0, double y0, double len, double angle) {
    if(len > 2) {
      double x1 = x0 + len * Math.cos((angle/360.0)*2*3.14159);
      double y1 = y0 - len * Math.sin((angle/360.0)*2*3.14159);
      
      StdDraw.setPenColor(Math.random(),Math.random(),Math.random());
      StdDraw.line(x0, y0, x1, y1);
      drawTree(x1, y1, len * 0.5, angle + 75); //==> .65, +.05
      drawTree(x1, y1, len * 0.5, angle - 75);
    }
  }
  public static void t7() {
    
    StdDraw.setCanvasSize(500,500);        
// set the scale of the coordinate system
    StdDraw.setXscale(-1.0, 1.0);
    StdDraw.setYscale(-1.0, 1.0);
    
    // initial values
    double rx = 0.320, ry = 0.860;     // position
    double orx = 0.480, ory = 0.860;     // old position
    double vx = 0.015, vy = 0.023;     // velocity
    
    double radius = 0.05;              // radius
    
    StdDraw.setPenColor(StdDraw.BLUE);
    StdDraw.filledSquare(0, 0, 1);
    
    // main animation loop
    while (true)  { 
      
      // bounce off wall according to law of elastic collision
      if (Math.abs(rx + vx) > 1.0 - radius) vx = -vx;
      if (Math.abs(ry + vy) > 1.0 - radius) vy = -vy;
      
      // update position
      rx = rx + vx; 
      ry = ry + vy; 
      
      // clear the background
      StdDraw.setPenColor(StdDraw.BLUE);
      StdDraw.filledSquare(orx, ory, radius+.01);
      orx = rx;
      ory = ry;
      
      // draw ball on the screen
      StdDraw.setPenColor(StdDraw.BLACK); 
      StdDraw.filledCircle(rx, ry, radius); 
      
      // display and pause for 20 ms
      StdDraw.show(20); 
    } 
  }
  
  public static void t8() {
    StdDraw.setCanvasSize(1000,700);
    StdDraw.setXscale(0, 1.0);
    StdDraw.setYscale(0, 1.0);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.clear();
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(.01);
    
//    while (true) {
//      if (StdDraw.mousePressed()){
//        StdDraw.point(StdDraw.mouseX(),StdDraw.mouseY());
//      }  
//    }
    StdDraw.setPenColor(.5,.5,0);
    StdDraw.filledSquare(.5,.5,5);
    for (int i = 1;i<200;i++) {
      //StdAudio.play(440*(Math.random()+1),.2,1);
      StdDraw.setPenColor(Math.random(),Math.random(),Math.random());
      StdDraw.line(Math.random(),Math.random(),Math.random(),Math.random());
      StdDraw.circle(Math.random(),Math.random(),Math.random()*.1);
    } // end for  
  } // end art()
  
  //-------------------------------------- 
  
  
  
  //-----------------------------------------------------------------
  
  /* myRand(int low, int high) returns a random integer, low<=r<=high
   * Paramaters: low, and high -- the range for the random number
   * Returns: the random integer
   */
  public static int myRand(int low, int high) {
    int rand=0;
    
    rand=((int)((Math.random()*(high-low+1))+low));
    
    return rand;
    
  } // end myRand()
  
//-----------------------------------------------------    
}//end class Fun


