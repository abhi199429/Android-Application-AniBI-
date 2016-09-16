package com.example.prayas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class reptilesym extends Activity {
	
Button repeye,repneck,repback,repstom,reptail1,reptail2,repleg1,repleg2,repleg3;
TextView rept1;
public static String dname,ddetail;
CheckBox repc1,repc2,repc3;


public static class diseas
{
	String Dis_name;
	String Dis_details;
	
	
}
public static diseas n2=new diseas();
public ArrayList<diseas> n1=new ArrayList<diseas>();


public static String NAMESPACE = "http://tempuri.org/";
public static String  URL = Homepage.ipadd;
public static String SOAP_ACTION = "http://tempuri.org/select_for_diseas";
String METHOD_NAME = "select_for_diseas"; 
String s1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
setContentView(R.layout.reptilesym);


repeye=(Button)findViewById(R.id.repeye);
repneck=(Button)findViewById(R.id.repneck);
repback=(Button)findViewById(R.id.repback);
repstom=(Button)findViewById(R.id.repstomach);
reptail1=(Button)findViewById(R.id.reptail);
reptail2=(Button)findViewById(R.id.reptail2);
repleg1=(Button)findViewById(R.id.repleg1);
repleg2=(Button)findViewById(R.id.repleg2);
repleg3=(Button)findViewById(R.id.repleg3);

rept1=(TextView)findViewById(R.id.reptext);


repeye.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rept1.setText(repeye.getText());
		
		
		repc1=(CheckBox)findViewById(R.id.reptcheckBox1);
		repc2=(CheckBox)findViewById(R.id.reptcheckBox2);
		repc3=(CheckBox)findViewById(R.id.reptcheckBox3);
		s1=repc1.getText().toString();
	//	repc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		repc1.setText("dis1");
		repc2.setText("dis2");
		repc3.setText("dis3");
		repc1.setChecked(false);
		repc2.setChecked(false);
		repc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		repc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=repc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				repc1.setChecked(true);
				repc2.setChecked(false);
				repc3.setChecked(false);
			}
		});
		
		repc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				repc2.setChecked(true);
				
				repc1.setChecked(false);
				repc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		repc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				repc1.setChecked(true);
				
				repc2.setChecked(false);
				repc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});


	}
});


repneck.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rept1.setText(repneck.getText());


		
		repc1=(CheckBox)findViewById(R.id.reptcheckBox1);
		repc2=(CheckBox)findViewById(R.id.reptcheckBox2);
		repc3=(CheckBox)findViewById(R.id.reptcheckBox3);
		s1=repc1.getText().toString();
	//	repc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		repc1.setText("dis1");
		repc2.setText("dis2");
		repc3.setText("dis3");
		repc1.setChecked(false);
		repc2.setChecked(false);
		repc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		repc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=repc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				repc1.setChecked(true);
				repc2.setChecked(false);
				repc3.setChecked(false);
			}
		});
		
		repc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				repc2.setChecked(true);
				
				repc1.setChecked(false);
				repc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		repc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				repc1.setChecked(true);
				
				repc2.setChecked(false);
				repc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});



	}
});
repback.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rept1.setText(repback.getText());

		
		repc1=(CheckBox)findViewById(R.id.reptcheckBox1);
		repc2=(CheckBox)findViewById(R.id.reptcheckBox2);
		repc3=(CheckBox)findViewById(R.id.reptcheckBox3);
		s1=repc1.getText().toString();
	//	repc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		repc1.setText("dis1");
		repc2.setText("dis2");
		repc3.setText("dis3");
		repc1.setChecked(false);
		repc2.setChecked(false);
		repc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		repc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=repc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				repc1.setChecked(true);
				repc2.setChecked(false);
				repc3.setChecked(false);
			}
		});
		
		repc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				repc2.setChecked(true);
				
				repc1.setChecked(false);
				repc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		repc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				repc1.setChecked(true);
				
				repc2.setChecked(false);
				repc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});


		
	}
});
repstom.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rept1.setText(repstom.getText());

		
		repc1=(CheckBox)findViewById(R.id.reptcheckBox1);
		repc2=(CheckBox)findViewById(R.id.reptcheckBox2);
		repc3=(CheckBox)findViewById(R.id.reptcheckBox3);
		s1=repc1.getText().toString();
	//	repc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		repc1.setText("dis1");
		repc2.setText("dis2");
		repc3.setText("dis3");
		repc1.setChecked(false);
		repc2.setChecked(false);
		repc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		repc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=repc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				repc1.setChecked(true);
				repc2.setChecked(false);
				repc3.setChecked(false);
			}
		});
		
		repc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				repc2.setChecked(true);
				
				repc1.setChecked(false);
				repc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		repc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				repc1.setChecked(true);
				
				repc2.setChecked(false);
				repc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});


		
	}
});
reptail1.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rept1.setText(reptail1.getText());

		
		repc1=(CheckBox)findViewById(R.id.reptcheckBox1);
		repc2=(CheckBox)findViewById(R.id.reptcheckBox2);
		repc3=(CheckBox)findViewById(R.id.reptcheckBox3);
		s1=repc1.getText().toString();
	//	repc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		repc1.setText("dis1");
		repc2.setText("dis2");
		repc3.setText("dis3");
		repc1.setChecked(false);
		repc2.setChecked(false);
		repc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		repc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=repc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				repc1.setChecked(true);
				repc2.setChecked(false);
				repc3.setChecked(false);
			}
		});
		
		repc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				repc2.setChecked(true);
				
				repc1.setChecked(false);
				repc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		repc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				repc1.setChecked(true);
				
				repc2.setChecked(false);
				repc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});


		
	}
});
reptail2.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rept1.setText(reptail2.getText());

		
		repc1=(CheckBox)findViewById(R.id.reptcheckBox1);
		repc2=(CheckBox)findViewById(R.id.reptcheckBox2);
		repc3=(CheckBox)findViewById(R.id.reptcheckBox3);
		s1=repc1.getText().toString();
	//	repc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		repc1.setText("dis1");
		repc2.setText("dis2");
		repc3.setText("dis3");
		repc1.setChecked(false);
		repc2.setChecked(false);
		repc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		repc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=repc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				repc1.setChecked(true);
				repc2.setChecked(false);
				repc3.setChecked(false);
			}
		});
		
		repc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				repc2.setChecked(true);
				
				repc1.setChecked(false);
				repc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		repc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				repc1.setChecked(true);
				
				repc2.setChecked(false);
				repc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});


		
	}
});
repleg1.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rept1.setText(repleg1.getText());

		
		repc1=(CheckBox)findViewById(R.id.reptcheckBox1);
		repc2=(CheckBox)findViewById(R.id.reptcheckBox2);
		repc3=(CheckBox)findViewById(R.id.reptcheckBox3);
		s1=repc1.getText().toString();
	//	repc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		repc1.setText("dis1");
		repc2.setText("dis2");
		repc3.setText("dis3");
		repc1.setChecked(false);
		repc2.setChecked(false);
		repc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		repc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=repc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				repc1.setChecked(true);
				repc2.setChecked(false);
				repc3.setChecked(false);
			}
		});
		
		repc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				repc2.setChecked(true);
				
				repc1.setChecked(false);
				repc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		repc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				repc1.setChecked(true);
				
				repc2.setChecked(false);
				repc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});


		
	}
});
repleg2.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rept1.setText(repleg2.getText());

		
		repc1=(CheckBox)findViewById(R.id.reptcheckBox1);
		repc2=(CheckBox)findViewById(R.id.reptcheckBox2);
		repc3=(CheckBox)findViewById(R.id.reptcheckBox3);
		s1=repc1.getText().toString();
	//	repc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		repc1.setText("dis1");
		repc2.setText("dis2");
		repc3.setText("dis3");
		repc1.setChecked(false);
		repc2.setChecked(false);
		repc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		repc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=repc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				repc1.setChecked(true);
				repc2.setChecked(false);
				repc3.setChecked(false);
			}
		});
		
		repc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				repc2.setChecked(true);
				
				repc1.setChecked(false);
				repc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		repc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				repc1.setChecked(true);
				
				repc2.setChecked(false);
				repc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});


		
	}
});
repleg3.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		rept1.setText(repleg3.getText());

		
		repc1=(CheckBox)findViewById(R.id.reptcheckBox1);
		repc2=(CheckBox)findViewById(R.id.reptcheckBox2);
		repc3=(CheckBox)findViewById(R.id.reptcheckBox3);
		s1=repc1.getText().toString();
	//	repc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	repc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		repc1.setText("dis1");
		repc2.setText("dis2");
		repc3.setText("dis3");
		repc1.setChecked(false);
		repc2.setChecked(false);
		repc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		repc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=repc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				repc1.setChecked(true);
				repc2.setChecked(false);
				repc3.setChecked(false);
			}
		});
		
		repc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				repc2.setChecked(true);
				
				repc1.setChecked(false);
				repc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		repc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=repc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				repc1.setChecked(true);
				
				repc2.setChecked(false);
				repc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});


		
	}
});


	}
	

class DoLogin2 extends AsyncTask<Void, Void, String>
{
	private ProgressDialog pdia;
	
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		try
		{
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	        request.addProperty("Dis_name",s1);

	        //request.addProperty("password", e2.getText().toString());
	        
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet=true;
	        envelope.setOutputSoapObject(request);
	        
	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        
	        androidHttpTransport.call(SOAP_ACTION, envelope);
	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
	        
	        Log.d("message","MEssage : "+resultstr.toString());
	        return resultstr.toString();
	        

		}
		catch(Exception e)
		{
			Log.e("error13", e.toString());
			return "fail,fail";
			
		}
			
		
		
	}
	
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		pdia = new ProgressDialog(reptilesym.this);
		pdia.setCanceledOnTouchOutside(false);
        pdia.setMessage("Loading...");
        pdia.show(); 
	}
	
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);    	    	
		
		
		pdia.dismiss();

		String pro[]=result.split("`");
		Toast.makeText(getApplicationContext(), pro[0].toString(), Toast.LENGTH_SHORT).show();
	
		n2.Dis_name=pro[0];
		n2.Dis_details=pro[1];
		ddetail=pro[1];
		Toast.makeText(getApplicationContext(), ddetail, 200).show();
		n1.add(n2);
		dsym1.t3.setText(n2.Dis_name);
		dsym1.t5.setText(ddetail);
		
		//t2.setText(n2.Dis_name);
		//t1.setText(n2.Dis_details);

			//Log.d("data",n2.news_d);
			
		
	}
}


}
