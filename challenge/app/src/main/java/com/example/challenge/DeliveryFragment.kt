package com.example.challenge


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge.databinding.FragmentDeliveryBinding
import com.example.challenge.presentation.adapter.DeliveryAdapter
import com.example.challenge.presentation.viewmodel.DeliveryViewModel


class DeliveryFragment : Fragment() {
    private  lateinit var viewModel: DeliveryViewModel
    private lateinit var deliveryAdapter: DeliveryAdapter
    private lateinit var layoutManager:LinearLayoutManager
    private lateinit var fragmentDeliveryBinding: FragmentDeliveryBinding
    private lateinit var navController: NavController
    private var offset = 0
    private var limit = 50
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delivery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = requireActivity() as MainActivity
        mainActivity.binding.activityTittle.text="My Delivery"
        mainActivity.binding.btnBack.visibility=View.GONE
        fragmentDeliveryBinding = FragmentDeliveryBinding.bind(view)
        viewModel= (activity as MainActivity).viewModel
        navController=findNavController()
        deliveryAdapter = DeliveryAdapter()
        deliveryAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_delivery",it)
            }
            navController.navigate(
                R.id.action_DeliveryFragment_to_DetailsFragment,
                bundle
            )
        }
        initRecyclerView()
        viewDeliveryList()

    }

    private fun viewDeliveryList() {

        viewModel.getDeliveris(offset,limit)


        viewModel.localDeliveries.observe(viewLifecycleOwner){
                 if(it!=null){
                  deliveryAdapter.differ.submitList(it.toList())
                     }
                 }




        viewModel.deliveries.observe(viewLifecycleOwner) { response ->
            when (response) {
                is com.example.challenge.data.util.Resource.Success -> {
                  hideProgressBar()
                    viewModel.getSavedDeliveries()
                }
                is com.example.challenge.data.util.Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(activity, "An error occurred : $it", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                is com.example.challenge.data.util.Resource.Loading -> {
                    showProgressBar()
                }

            }
        }
    }

    private fun initRecyclerView() {
        val dividerItemDecoration =
            DividerItemDecoration(fragmentDeliveryBinding.rvDelivery.context, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(
            ContextCompat.getDrawable(
                fragmentDeliveryBinding.rvDelivery.context,
                R.drawable.divider
            )!!
        )
        fragmentDeliveryBinding.rvDelivery.addItemDecoration(dividerItemDecoration)
        fragmentDeliveryBinding.rvDelivery.layoutManager=LinearLayoutManager(activity)
        fragmentDeliveryBinding.rvDelivery.adapter=deliveryAdapter



    }

    private fun showProgressBar(){
        fragmentDeliveryBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        fragmentDeliveryBinding.progressBar.visibility = View.INVISIBLE
    }

}