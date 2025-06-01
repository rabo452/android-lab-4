package com.university_assignment.lab4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.university_assignment.lab4.R

class ImageFragment : Fragment() {
    private var imageResId: Int = 0  // default 0 means no image

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageResId = arguments?.getInt(ARG_IMAGE_RES_ID, 0) ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgBlock = view.findViewById<ImageView>(R.id.img_block)
        if (imageResId != 0) {
            imgBlock.setImageResource(imageResId)
        }
    }

    companion object {
        private const val ARG_IMAGE_RES_ID = "image_res_id"

        @JvmStatic
        fun newInstance(imageResId: Int): ImageFragment {
            val fragment = ImageFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_IMAGE_RES_ID, imageResId)
            fragment.arguments = bundle
            return fragment
        }
    }
}
