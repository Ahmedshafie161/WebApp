package com.example.webapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.webapp.databinding.FragmentPostsBinding

class PostsFragment : Fragment(R.layout.fragment_posts) {

    lateinit var fragmentPostsBinding:FragmentPostsBinding
    val customAdapter= CustomAdapter(ArrayList())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentPostsBinding= FragmentPostsBinding.inflate(layoutInflater)
        return fragmentPostsBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RetrofitClient.getPosts{postArraylist:ArrayList<PostItem>
         ->   customAdapter.updateList(postArraylist)
        }

        fragmentPostsBinding.recyclerView.apply {
            layoutManager=GridLayoutManager(activity,1,GridLayoutManager.VERTICAL,false)
            adapter=customAdapter
        }
    }
}