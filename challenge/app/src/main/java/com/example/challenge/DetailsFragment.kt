package com.example.challenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.challenge.data.model.DeliveryResponseItem
import com.example.challenge.data.model.Favorite
import com.example.challenge.databinding.FragmentDetailsBinding
import com.example.challenge.presentation.viewmodel.DeliveryViewModel
import com.google.android.material.snackbar.Snackbar

class DetailsFragment : Fragment() {
    private lateinit var fragmentDetailsBinding: FragmentDetailsBinding
    private lateinit var viewModel : DeliveryViewModel
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = requireActivity() as MainActivity
        mainActivity.binding.activityTittle.text="Delivery Details"
        mainActivity.binding.btnBack.visibility=View.VISIBLE
        navController=findNavController()
        mainActivity.binding.btnBack.setOnClickListener{
            navController.navigateUp()
        }
        fragmentDetailsBinding = FragmentDetailsBinding.bind(view)
        val args :DetailsFragmentArgs by navArgs()
        var deliveryResponseItem = args.selectedDelivery

        viewModel=(activity as MainActivity).viewModel

        fragmentDetailsBinding.tvFromValue.text=deliveryResponseItem.route.start
        fragmentDetailsBinding.tvToValue.text=deliveryResponseItem.route.end
        fragmentDetailsBinding.tvDeliveryPrice.text=deliveryResponseItem.deliveryFee
        fragmentDetailsBinding.tvName.text=deliveryResponseItem.remarks
        Glide.with(fragmentDetailsBinding.ivGoodsImage.context).
        load(deliveryResponseItem.goodsPicture).
        into(fragmentDetailsBinding.ivGoodsImage)

        fragmentDetailsBinding.btnAddFavorite.setOnClickListener {

                viewModel.saveFavDelivery(Favorite(deliveryResponseItem.id,true))
                Snackbar.make(view,"Added to Favorite", Snackbar.LENGTH_LONG).show()


        }
    }
}