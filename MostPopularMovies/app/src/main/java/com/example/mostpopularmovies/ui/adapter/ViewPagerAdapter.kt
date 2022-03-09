import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, behaviorResumeOnlyCurrentFragment: Int) :
    FragmentPagerAdapter(fragmentManager, behaviorResumeOnlyCurrentFragment) {

    private val fragmentList = mutableListOf<Fragment>()
    private val fragmentTitle = mutableListOf<String>()

    override fun getCount() = fragmentList.size
    override fun getItem(position: Int) = fragmentList[position]

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitle.add(title)
        notifyDataSetChanged()
    }

    override fun getPageTitle(position: Int) = fragmentTitle[position]

}