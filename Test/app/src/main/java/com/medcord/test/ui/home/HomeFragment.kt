package com.medcord.test.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.medcord.test.R
import com.medcord.test.viewmodel.HomeViewModel

class HomeFragment : Fragment() ,View.OnClickListener {

    val TAG:String = "HomeFragment";
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var button1: Button;
    private lateinit var button2: Button;
    private lateinit var button3: Button;
    private lateinit var button4: Button;

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        button1 = root.findViewById(R.id.btn1);  button1.setOnClickListener(this);
        button2 = root.findViewById(R.id.btn2);  button2.setOnClickListener(this);
        button3 = root.findViewById(R.id.btn3);  button3.setOnClickListener(this);
        button4 = root.findViewById(R.id.btn4);  button4.setOnClickListener(this);

        observeApiResponse();
        return root
    }

    private fun observeApiResponse() {
        homeViewModel.realdata.observe(viewLifecycleOwner, Observer {
            Toast.makeText(
                requireContext(),
                " String: ${it.data.rstr}" ,
                Toast.LENGTH_LONG
            ).show()
        });

    }

    override fun onClick(v: View?) {
        var jsonObj:HashMap<String,String> = HashMap();
        when(v?.id){
            R.id.btn1 ->  {
                Log.d(TAG,"clicked on btn1")
                jsonObj.put("bname","B1");
            }
            R.id.btn2 ->   jsonObj.put("bname","B2");
            R.id.btn3 ->  jsonObj.put("bname","B3");
            R.id.btn4 ->  jsonObj.put("bname","B4");

        }
       homeViewModel.getData(jsonObj)

    }




}
