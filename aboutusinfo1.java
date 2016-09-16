package com.example.prayas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class aboutusinfo1 extends Activity {

	ImageView im1;
	TextView atv1;
	Button bb1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.aboutusinfo);
	    bb1=(Button)findViewById(R.id.birdeye);
	    im1=(ImageView)findViewById(R.id.imageView1);
	    atv1=(TextView)findViewById(R.id.disdetailtv1);
	    String str="";
	    if(P_Aboutus.flag==1)
	    {
	    str="The history has loud and clear evidence that lack of creative activism has put generations on decline; both existentially and spiritually. The similar situation persists today also where the industrialization and modern consumerism has resulted into a death-wish for the mankind. Environmental degradation and continuous abuse of Mother Nature has rendered this heavenly planet to the brink of a disaster. Some concerned and motivated people have always tried their best to make the society to come out of its blind race for obvious materialism. It will be a complete misfortune if our age of great scientific discoveries fails to understand the basic need to conserve our environment and nature.";
	    atv1.setText(str);
	    }
	    
	    if(P_Aboutus.flag==2)
	    {
	    str="To strive in united team endeavor for conservation of nature and protection of environment through education and direct action.";
	    atv1.setText(str);
	    }
	    
	    if(P_Aboutus.flag==3)
	    {
	    str="To work towards building a sensitive human society that values the human existence on earth in tune with nature, starting from small community actions and working at grass root.Creating a strong voice in support of environmental issues amongst urban and rural community.To extend our resources and abilities to the government and non-government organizations with similar objectives towards environment and nature.";
	    atv1.setText(str);
	    }
	    
	    if(P_Aboutus.flag==4)
	    {
	    str="What we are doing to the forests of the world is but a mirror reflection of what we are doing to ourselves and to one another.";
	    atv1.setText(str);
	    }
	    
	    if(P_Aboutus.flag==5)
	    {
	    	String str1="Our prime objective is to plan, design and conduct environment education programs in schools & common people. They include presentations, quiz, movies, talks, games, street plays and puppet shows. Publications and resource material like books, audio/video material, leaflets, and e-learning courses are our important tools that we are planning to evolve.";
            String str2="Our direct action campaigns include habitat conservation, energy conservation, alternative and renewable energy projects, Reduce - Reuse - Recycle projects, water conservation and harvesting, waste minimization and urban eco-community projects involving community and educational institutions.";  	    
	    	String str3="Kindness is contagious the motto of Animal Welfare Board of India (AWBI) is the driving force for our rescue & relief of animals, birds, reptiles in distress. We propagate public awareness for compassion for animals";
            String str4="Wildlife rescue & rehabilitation interests many of our members. We advocate wildlife habitat conservation and protection of wildlife at all possible levels.We are working on or planning important projects with the Forest Department Gujarat State. We are a part of Wildlife Rehabilitators Exchange Network (WREN) of Wildlife Trust of India (WTI) to look after the wildlife issues in South Gujarat.";
	    	str=str1+"\n"+str2+"\n"+str3+"\n"+str4;
	        atv1.setText(str);
	    }

	bb1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			finish();
		}
	});
	}

}
