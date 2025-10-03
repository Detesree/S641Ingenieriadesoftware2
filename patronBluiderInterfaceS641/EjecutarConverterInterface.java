public class EjecutarConverterInterface {
    public static void main(String[] args) {
        
        //Creación de los objetos de tipo Converter
        ConverterI objASCII = new ASCIIConverterI();
        ConverterI objPostScript = new PostScriptConverterI();
        ConverterI objPDF = new PDFConverterI();
        ConverterI objWord = new WordConverterI();

        //Creación de los objetos de tipo Lector
        ReaderI objLector1 = new ReaderI("LINE", objASCII);
        ReaderI objLector2 = new ReaderI("TABLE", objPDF);
        ReaderI objLector3 = new ReaderI("LINE", objPostScript);
        ReaderI objLector4 = new ReaderI("PARAGRAPH", objWord);

        objLector1.parseInput();
        objLector2.parseInput();
        objLector3.parseInput();
        objLector4.parseInput();




    }
}