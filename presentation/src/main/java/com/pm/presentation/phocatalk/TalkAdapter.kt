package com.pm.presentation.phocatalk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.pm.presentation.databinding.RvPhocaTalkListItemBinding
import com.pm.presentation.phocatalk.model.TalkVO
import com.pm.presentation.phocatalk.util.TalkDiff
import java.text.SimpleDateFormat
import java.util.*

class TalkAdapter : ListAdapter<TalkVO, TalkAdapter.TalkViewHolder>(TalkDiff()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TalkViewHolder {
        val view =
            RvPhocaTalkListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TalkViewHolder(view)
    }

    override fun onBindViewHolder(holder: TalkViewHolder, position: Int) {
        val item = getItem(position)

        holder.itemView.setOnClickListener {

        }
        holder.bind(item)
    }

    inner class TalkViewHolder(private val binding: RvPhocaTalkListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TalkVO) {
            binding.item = item

            when (item.status) {
                1 -> {
                    binding.tvGoodsStatus.text = "구매중"
                }
                2 -> {
                    binding.tvGoodsStatus.text = "구매완료"
                }
                else -> {

                }
            }

            when (item.need) {
                1 -> {
                    binding.tvGoodsNeed.text = "재등록필요"
                }
                2 -> {
                    binding.tvGoodsNeed.text = ""
                }
                else -> {

                }
            }
            binding.notiBadge.visibility =
                if (item.notReadCount == 0) View.INVISIBLE else View.VISIBLE
            binding.tvLastChatDate.text = transFromDate(item.time)
            binding.imageView.load(item.path) {
                transformations(RoundedCornersTransformation(10f))
            }
        }

        private fun transFromDate(time: Long): String {
            val df = SimpleDateFormat("yyyy-MM-dd, HH:mm", Locale.KOREA)
            return df.format(Date(time))
        }
    }


}