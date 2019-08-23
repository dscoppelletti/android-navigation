/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

/**
 * Fragment used to show how to navigate to another destination
 */
class HomeFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* DOC STEP 5
        The NavController is what triggers the fragment swaps in the
        NavigationHostFragment.

        Note that you pass in either a destination or action ID to navigate.
        These are the IDs defined in the navigation graph XML. This is an
        example of passing in a destination ID.

        NavController is powerful because when you call methods like navigate()
        or popBackStack(), it translates these commands into the appropriate
        framework operations based on the type of destination you are navigating
        to or from. For example, when you call navigate() with an activity
        destination, the NavController calls startActivity() on your behalf.

        There are a few ways to get a NavController object associated with your
        NavHostFragment. In Kotlin, it's recommended you use one of the
        following extension functions, depending on whether you're calling the
        navigation command from within a fragment, activity or view:

        . Fragment.findNavController()
        . View.findNavController()
        . Activity.findNavController(viewId: Int)
        DOC END STEP 5 */

        //TODO STEP 5 - Set an OnClickListener, using Navigation.createNavigateOnClickListener()
        /* DOC STEP 6
        This has been replaced by STEP 6
        DOC END STEP 6 */
//        val button = view.findViewById<Button>(R.id.navigate_destination_button)
//        button?.setOnClickListener {
//            findNavController().navigate(R.id.flow_step_one_dest, null)
//
//            /* DOC STEP 5
//            You can also use the following convenience method
//            Navigation.createNavigationOnClickListener(R.id.flow_step_one, null)
//            DOC END STEP 5 */
//        }
        //TODO END STEP 5

        /* DOC STEP 6
        The default transition, as well as other attributes associated with the
        call, can be overridden by including a set of NavOptions. NavOptions
        uses a Builder pattern which allows you to override and set only the
        options you need. There's also a ktx DSL for NavOptions, which is what
        you'll be using.

        For animated transitions, you can define XML animation resources in the
        anim resource folder and then use those animations for transitions. Some
        examples are included in the app code:

        +- res
           +- anim
               +- fade_in.xml
                  fade_out.xml
                  slide_in_left.xml
                  slide_in_right.xml
                  slide_out_left.xml
                  slide_out_right.xml
        DOC END STEP 6 */

        //TODO STEP 6 - Set NavOptions
        /* DOC STEP 6
        This replaces STEP 5
        DOC END STEP 6 */
        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        view.findViewById<Button>(R.id.navigate_destination_button)?.setOnClickListener {
            findNavController().navigate(R.id.flow_step_one_dest, null, options)
        }
        //TODO END STEP 6

        /* DOC STEP 7
        Actions allow you to attach NavOptions in the navigation XML file,
        rather than specifying them programmatically.
        DOC END STEP 7 */

        /* DOC STEP 8
        You can also use safe args to navigate in a type safe way, with or
        without adding arguments. You do this using the generated Directions
        classes.

        +- com.example.android.codelabs.navigation
           +- DeepLinkFragmentArgs
              FlowStepFragmentArgs
              FlowStepFragmentDirections
              HomeFragmentDirections
        DOC END STEP 8 */

        //TODO STEP 7.2 - Update the OnClickListener to navigate using an action
        /* DOC STEP 8
        This has been replaced by STEP 6
        DOC END STEP 8 */
//        view.findViewById<Button>(R.id.navigate_action_button)?.setOnClickListener(
//                Navigation.createNavigateOnClickListener(R.id.next_action, null)
//        )
        //TODO END STEP 7.2

        //TODO STEP 8 - Update the OnClickListener to navigate using Safe Args Direction classes
        /* DOC STEP 8
        This replaces STEP 7.2
        DOC END STEP 8 */
        view.findViewById<Button>(R.id.navigate_action_button)?.setOnClickListener {
            val flowStepNumberArg = 1
            val action = HomeFragmentDirections.nextAction(flowStepNumberArg)
            findNavController().navigate(action)
        }
        //TODO END STEP 8
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    // TODO STEP 12 - Have the shopping cart icon open up your new fragment
    //  class, using NavigationUI to handle the menu.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.shopping_cart -> {
                findNavController()
                        .navigate(R.id.shopping_dest)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
    // TODO END STEP 12
}
