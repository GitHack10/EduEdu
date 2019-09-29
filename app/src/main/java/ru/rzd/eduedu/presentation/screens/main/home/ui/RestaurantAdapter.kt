package ru.rzd.eduedu.presentation.screens.main.home.ui

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_restaurant.*
import ru.rzd.eduedu.R
import ru.rzd.eduedu.domain.global.models.Restaurant
import ru.rzd.eduedu.presentation.global.utils.inflate

class RestaurantAdapter(
    var list: List<Restaurant>,
    private val itemClickListener: (Long) -> Unit
) : ListAdapter<Restaurant, RecyclerView.ViewHolder>(
    DiffCallback()
) {

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TITLE_VIEW_TYPE
            else -> DEFAULT_VIEW_TYPE
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TITLE_VIEW_TYPE -> TitleHolder(
                view = viewGroup.inflate(R.layout.item_title_restaurant)
            )
            else -> RestaurantHolder(
                containerView = viewGroup.inflate(R.layout.item_restaurant),
                itemClickListener = itemClickListener
            )
        }
    }

    override fun getItemCount(): Int = list.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RestaurantHolder -> holder.setData(getItem(position - 1))
        }
    }

    class RestaurantHolder(
        override val containerView: View,
        private val itemClickListener: (Long) -> Unit
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        private val bannerImageView = bannerRestImage
        private val logoImageView = logoRestImage
        private val nameTextView = nameRestTextView
        private val typeTextView = typeRestTextView

        fun setData(restaurant: Restaurant) {

            Glide.with(containerView)
                .load(restaurant.banner)
                .placeholder(containerView.resources.getDrawable(R.drawable.placeholder_restaurant))
                .into(bannerImageView)

            Glide.with(containerView)
                .load(restaurant.logo)
                .placeholder(containerView.resources.getDrawable(R.drawable.placeholder_restaurant_logo))
                .into(logoImageView)


            nameTextView.text = restaurant.name
            if (restaurant.typeKitchen.isNotEmpty()) typeTextView.text = restaurant.typeKitchen
            if (restaurant.schedule.isNotEmpty()) workScheduleTextView.text = restaurant.schedule

            itemView.setOnClickListener { itemClickListener.invoke(restaurant.id) }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.equals(newItem)
        }
    }

    class TitleHolder(view: View) : RecyclerView.ViewHolder(view)

    companion object {

        private const val TITLE_VIEW_TYPE = 0
        private const val DEFAULT_VIEW_TYPE = 1
    }
}
