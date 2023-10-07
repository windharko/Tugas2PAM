package com.example.pamsearch.ui.skill

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pamsearch.databinding.ItemCustomBinding
import com.example.pamsearch.R
import com.example.pamsearch.ui.helper.SkillUtil

class SkillAdapter(private val fragment: Fragment, val listener: (string: String) -> Unit) :
    RecyclerView.Adapter<SkillAdapter.ViewHolder>(),Filterable {

    private val skillDataList = SkillUtil.getSkillData(fragment)
    private var filteredSkills: List<SkillData> = skillDataList

    inner class ViewHolder(private val binding: ItemCustomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(skillData: SkillData) {
            binding.textSkill.text = skillData.name
            binding.imageSkill.setImageResource(skillData.imageResId)
            binding.root.setOnClickListener {
                listener(skillData.name)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = ItemCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filteredSkills[position])
    }

    override fun getItemCount(): Int = filteredSkills.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val searchText = constraint.toString().toLowerCase()
                filteredSkills = if (searchText.isEmpty()) {
                    skillDataList
                } else {
                    skillDataList.filter { it.name.toLowerCase().contains(searchText) }
                }
                val results = FilterResults()
                results.values = filteredSkills
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredSkills = results?.values as List<SkillData>
                notifyDataSetChanged()
            }
        }
    }
}