package com.exa.Dec2bin;

import java.util.Stack;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import java.util.*;



public class _MainActivity extends Activity implements View.OnClickListener {

	EditText txtDecimal,txtBinary;

    Button btnAbout;

    /** other comment */

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity___main);

        txtDecimal=(EditText)findViewById(R.id.txtDecimal);
        txtBinary=(EditText)findViewById(R.id.txtBinary);

        btnAbout=(Button)findViewById(R.id.button1);
        btnAbout.setOnClickListener(this);
    }

    public String dec2bin(String dec)
    {

    	int base=2;

        if(dec.trim().length()==0)
        {
            return "";
        }

        else
        {
            Stack<Object> stack=new Stack<Object>();
            int number=Integer.parseInt(dec);
            while (number>0)
            {
                int remainder=number%base; // find remainder
                if(remainder<10)
                // for remainder smaller than 10
                {
                    stack.push(remainder);
                    // push remainder in stack
                }
                else
                {
                    switch (remainder)
                    // for remainder larger than 9 (for hexadecimal values)
                    {
                    case 10:
                        stack.push("A");
                        break;
                    case 11:
                        stack.push("B");
                        break;
                    case 12:
                        stack.push("C");
                        break;
                    case 13:
                        stack.push("D");
                        break;
                    case 14:
                        stack.push("E");
                        break;
                    case 15:
                        stack.push("F");
                        break;
                    }
                }
                number/=base;
            }
            StringBuffer buffer=new StringBuffer();
            while (!stack.isEmpty())
            {
                buffer.append(stack.pop().toString());
            }

    		return buffer.toString();

        }

    }


    public String bin2dec(String bin){


    	if(bin.trim().length()==0)
        {
            return "";
        }
    	else{
    		int ans=0,length=bin.length();
    		for(int i=0;i<length;i++){
    			if(bin.charAt(i)==48||bin.charAt(i)==49)
    				ans+=((bin.charAt((length-1)-i)-48)*Math.pow(2,i));
    			else
    				return "error";
    		}
    		return String.valueOf(ans);
    	}

    }

	public void onClick(View view)
	// to display Information in a dialog box
	{


	   String dec=txtDecimal.getText().toString(), _dec;
	   String bin=txtBinary.getText().toString(), _bin;

	   _bin=dec2bin(dec);
	   _dec=bin2dec(bin);


	   // create a dialog box
	   Builder builder=new Builder(this);
	   // to allow cancelling the dialog box
	   builder.setCancelable(true);
	   // set title

	   builder.setTitle("Los Resultados son:");
	   // set message
	   builder.setMessage("Binario: "+_bin+"   Decimal: "+_dec);
	   // display dialog box
	   builder.show();
	}
}


