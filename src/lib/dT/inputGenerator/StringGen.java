package lib.dt.inputGenerator;
import lib.dt.inputGenerator.regEx.Generex;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Neel Patel
 */
public class StringGen {
     Generex[] ar;
     Random rn=new Random();
     
     /** 
      * @param regx array of {@code String} representing valid regular expression.
      * @throws IllegalArgumentException if an error occurred while parsing the given regular expression
      * @throws StackOverflowError if the regular expression has to many transitions
      */
     public StringGen(String... regx){
          ar=getGenerex(regx);
     }
     
     /**return array of {@code Generex} related to string array {@param reg}.
      * this method remove duplicates from the array {@param reg}.
      * {@param reg} remain unchanged.
      * @param reg array of {@code String} representing valid regular expression.
      * @return Array of {@code Generex} related to {@param reg}.
      * @throws IllegalArgumentException if an error occurred while parsing the given regular expression
      * @throws StackOverflowError if the regular expression has to many transitions
      */
     Generex[] getGenerex(String reg[]){
          Generex g[]=Arrays.stream(reg).distinct()
                    .map(Generex::new).collect(Collectors.toList()).toArray(new Generex[0]);
          return g;
     }
     
     /**return a random String.
      * it generate the string using any one of the regular expression passed in constructor.
      * @return valid string generated using one of the regular expressions.
      */
     public String nextString(){
          //get random Generex from ar.
          Generex g=ar[ar.length>1?rn.nextInt(ar.length):0];
          return g.random();
     }
     
     /**
      * return a random String of length between {@param minlen} & {@param maxlen}.
      * it generate the string using any one of the regular expression passed in constructor.
      * if {@param maxlen} is negative or zero then it return any string having length greater than {@param minlen}
      * the {@code IllegalArgumentException} is thrown if {@param minlen}
       is greater than {@param maxlen} or {@param minlen} is less than {code zero}.
      * @param minlen minimum length of regular expression
      * @param maxlen maximum length of regular expression
      * @return valid string generated using one of the regular expressions.
      */
     public String nextString(int minlen,int maxlen){
          //get random Generex from ar.
          Generex g=ar[ar.length>1?rn.nextInt(ar.length):0];
          if(maxlen < minlen)
               throw new IllegalArgumentException();
          if(maxlen > 0)
               return g.random(minlen, maxlen);
          else
               return g.random(minlen);
     }
     
}
