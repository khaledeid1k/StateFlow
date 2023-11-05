package com.kh.mo.myapplication.ui.products

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.kh.mo.myapplication.R
import com.kh.mo.myapplication.databinding.ActivityMainBinding
import com.kh.mo.myapplication.model.Product
import com.kh.mo.myapplication.ui.products_details.MainActivity2
import com.kh.mo.myapplication.ui.products_details.ProductDetailsFragment
import com.kh.mo.myapplication.utils.Constants

class MainActivity : AppCompatActivity(), MoveData {

    lateinit var   binding : ActivityMainBinding
    private var productDetailsFragment: ProductDetailsFragment? = null
    private lateinit var fragmentTransaction: FragmentTransaction
    private  var sendProduct: SendProduct?=null
    private var product = Product(0, "", "", 0.0,0.0, 0.0,0,"","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(
         this,R.layout.activity_main
     )
//        binding.lifecycleOwner=this
        inti()
        setUp()


    }

    private fun inti() {
        Constants.Flag = resources.configuration.orientation
        val fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager.beginTransaction()

    }
    private fun receiveData() :Product?{
        val receivedIntent = intent
        val receivedBundle = receivedIntent?.getBundleExtra(Constants.dataBundle)
        return receivedBundle?.getSerializable(Constants.myData) as? Product
    }
    private fun setUp(){
        if (Constants.Flag == 2) {
            productDetailsFragment =
                supportFragmentManager.findFragmentByTag(Constants.productDetailsFragment) as? ProductDetailsFragment
            if (productDetailsFragment == null) {
                addProductDetailsFragment()
            }
            sendProduct=productDetailsFragment!!


        }
    }



    private fun addProductDetailsFragment() {
        productDetailsFragment = ProductDetailsFragment()
        fragmentTransaction.add(
            R.id.container_land_2,
            productDetailsFragment!!,
            Constants.productDetailsFragment
        )
        fragmentTransaction.commit()
    }

    override fun moveProduct(product: Product) {
        if(Constants.Flag==2) {
            sendProduct?.sendData(product)
        }else{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(Constants.dataBundle, product)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "$product", Toast.LENGTH_SHORT).show()
        sendProduct?.sendData(receiveData()?: product)

    }

}