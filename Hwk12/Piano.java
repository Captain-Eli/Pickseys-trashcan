public class Piano{
  public static void main(String args){
  char pianoKey='';
    StdDraw.SetCanvasSize(800,800);
    if(StdDraw.hasNextKeyTyped()){
   c = StdDraw.nextKeyTyped();
   if(c == 'q')play(68437__pinkyfinger__piano-a.wav);
    }
  }
}