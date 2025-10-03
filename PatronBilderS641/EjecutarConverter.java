public class EjecutarConverter {
    public static void main(String[] args) {
        
        //Creacion de los obj tipo Converter 

        Converter objASCII = new ASCIIConverterI();
        Converter objPostScript = new PostScriptConverter();
        Converter objPDF = new PDFConverter();

        Reader objLector1 = new Reader("LINE", objASCII);
        Reader objLector2 = new Reader("TABLE", objPDF);
        Reader objLector3 = new Reader("PARAGRAPH", objPostScript);

        objLector1.parseInput();
        objLector2.parseInput();
        objLector3.parseInput();
        
        


    
    }
}
