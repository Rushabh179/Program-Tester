package lib.runDetails;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * this is factory class which provide methods to read or write {@code IntIODetail}
   object to the specified streams.
 * @author Neel Patel
 */
class ObjectHandler {
     private ObjectHandler(){}
     
     /**
      * this method writes object to the output stream.
      * this method writes the object {@param o} to the output stream {@param out}.
      * it close the output stream after writing done.
      * it return true if the object written to the stream successfully, return
        false otherwise.
      * it throws IOException if the underlying stream throws.
      * @param out Output stream on which object {@param o} will be written.
      * @param o object of type {@code IntIODetail} which will be written on the
        stream.
      * @return true if object written successfully, false otherwise
      * @throws IOException if the underlying stream throws.
      */
     public static boolean writeObj(OutputStream out,IntIODetail o) throws IOException{
          ObjectOutputStream objOut=new ObjectOutputStream(out);
          try{
               objOut.writeObject(o);
          }catch(InvalidClassException | NotSerializableException e){
               return false; 
          }
          return true;
     }
     
     /**
      * this method reads object to the input stream.
      * this method reads the object from input stream {@param in}.
      * it close the input stream after reading done.
      * it return object if the object read from the stream successfully, return
        null otherwise.
      * it throws IOException if the underlying stream throws.
      * @param in input stream from which object will be read.
      * @return object if object read successfully, null otherwise
      * @throws IOException if the underlying stream throws.
      */
     public static IntIODetail readObj(InputStream in) throws IOException{
          ObjectInputStream objIn=new ObjectInputStream(in);
          try{
               IntIODetail ob=(IntIODetail)objIn.readObject();
               return ob;
          } catch(ClassNotFoundException | InvalidClassException 
                    | StreamCorruptedException | OptionalDataException e) {
               return null;
          }
     }
}
