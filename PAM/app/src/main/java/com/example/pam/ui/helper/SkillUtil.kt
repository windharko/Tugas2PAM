package com.example.pamsearch.ui.helper

import androidx.fragment.app.Fragment
import com.example.pamsearch.ui.skill.SkillData
import com.example.pamsearch.R

object SkillUtil{
    fun getSkillData(fragment: Fragment):ArrayList<SkillData>{
        val skillArrayList = ArrayList<SkillData>()
        val skills = fragment.resources.getStringArray(R.array.string_skill_array)
        val images = fragment.resources.obtainTypedArray(R.array.integer_skill_array)
        for (i in skills.indices){
            skillArrayList.add(SkillData(images.getResourceId(i,0), skills[i]))
        }
        images.recycle()
        return skillArrayList
    }
}