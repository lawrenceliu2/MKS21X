import java.util.*;

public class BarCode implements Comparable{
    // instance variables
    private String _zip;
    private int _checkDigit;
    private ArrayList<String> Bars;

    // constructors
    //precondtion: zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public BarCode(String zip) {
	if (_zip.length()!=5){throw new IndexOutOfBoundsException();}
	for (int i=0;i<zip.length();i++){
	    _zip+=zip.substring(i,i+1);
	}
	int sum=0;
	for (int i=0;i<_zip.length();i++){
	    sum+=((int)_zip.charAt(i));
	}
	_checkDigit=sum%10;
	Bars= new ArrayList<String>();
	Bars.add("||:::");
	Bars.add(":::||");
	Bars.add("::|:|");
	Bars.add("::||:");
	Bars.add(":|::|");
	Bars.add(":|::|");
	Bars.add(":||::");
	Bars.add("|:::|");
	Bars.add("|:::|");
	Bars.add("|:|::");
    }

    // postcondition: Creates a copy of a bar code.
    public BarCode(BarCode x){
	this(x._zip);
    }


    //post: computes and returns the check sum for _zip
    private int checkSum(){
	int sum=0;
	for (int i=0;i<_zip.length();i++){
	    sum+=((int)_zip.charAt(i));
	}
	return sum;
    }

    //postcondition: format zip + check digit + barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	String ans="|";
	for (int i = 0;i<5;i++){
	    ans+=Bars.get((int)(_zip.charAt(i)));
	}
	ans+=Bars.get(_checkDigit)+"|";
}


    public boolean equals(Object other){
	// postcondition: false if the object is not a BarCode, 
	// false if it is a non-matching barcode
	// true when they match.
	return other instanceof BarCode && _zip.equals (((BarCode)other)._zip);
    }


    public int compareTo(Comparable other){
	if (equals(other)){
	    return 0;
	}
	String data=_zip+_checkDigit;
	String ans=other._zip+other._checkDigit;
	return data.compareTo(ans);
    }
    // postcondition: compares the zip + checkdigit 

}
