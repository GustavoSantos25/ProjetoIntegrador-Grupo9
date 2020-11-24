package com.example.projetointegrador.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.projetointegrador.R
import kotlinx.android.synthetic.main.fragment_home_v_p.view.*


class HomeVPFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater!!.inflate(R.layout.fragment_home_v_p, container, false)
        val adapter = HomeFragmentsPagerAdapter(parentFragmentManager)
        adapter.addFragment(PerfilFragment(), "Perfil")
        adapter.addFragment(HomeFragment(), "Play")
        adapter.addFragment(ConfiguracoesFragment(), "Configurações")
        view.vpHome.adapter = adapter
        view.tlHome.setupWithViewPager(view.vpHome)

        view.tlHome.getTabAt(0)!!.setIcon(R.drawable.ic_perfil)
        view.tlHome.getTabAt(1)!!.setIcon(R.drawable.ic_play_home)
        view.tlHome.getTabAt(2)!!.setIcon(R.drawable.ic_config)
        view.tlHome.setTabIconTintResource(R.color.black)
        return view
    }

    private inner class HomeFragmentsPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private val listFrag = ArrayList<Fragment>()
        private val listTitles = ArrayList<String>()

        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment = listFrag[position]

        override fun getPageTitle(position: Int): CharSequence?  = listTitles[position]

        fun addFragment(frag : Fragment, title : String){
            listFrag.add(frag)
            listTitles.add(title)
        }
    }


}