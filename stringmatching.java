
class stringmatching{
public static void main(String[] args) {
    String text="havishshetty";
    String pattern="shetty";
    for(int i=0,j=0;j<pattern.length() && i<text.length();){
        if(text.charAt(i+j)==pattern.charAt(j)){
            j++;
            if(j==pattern.length()){
                System.out.println("Pattern Found");
                return;
            }
        }
        else{
            j=0;
            i++;
        }
    }
    System.out.println("Pattern not Found");
    
}
}