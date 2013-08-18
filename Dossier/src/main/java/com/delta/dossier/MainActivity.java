package com.delta.dossier;

import java.util.Locale;

import android.R;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    private static Person person;
    private AppItem[] appItems;
    private ListView mListView;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
     * will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add peron and appitem
        person = new Person("Kin", "Fong", "Java/Android Developer", 1, "1955 Clover Road,\nN" +
                "orthbrook, IL 60062", "(847) 530-7984", "bradley.kin.fong@gmail.com", "1149511268",
                "https://www.facebook.com/kin.fong.is.cool", 373363652, "https://twitter.com/ki" +
                "nfongiscool", "http://www.linkedin.com/pub/kin-fong/1b/695/45", "Hope Coll" +
                "ege\n  Bachelor of Arts\n  Psychology and Religion\n  GPA: 3.60/4.00\n\nWork Experien" +
                "ce:\n  Researcher at \n    Johnson Controls, Inc.\n  Research and Teaching Assistant at" +
                "\n    Hope College\n  Production Assistant at\n    Etymotic Research.\n\nSkills\n  Java Deve" +
                "lopment\n  Android Development\n  Photography\n  Adobe Photoshop\n  Adobe Lightroom\n  Ado" +
                "be InDesign\n\nCollege Involvement:\n  Hope College Worship Team\n    Bass Guitar\n  " +
                "Hope College Distinguished Artist Award\n    Jazz Saxophone",  3);



        // enter items for app list
        appItems = new AppItem[] {
                new AppItem("BarSpeak", "Simple app that displays text\nto easily signal others\n" +
                        "in a noisy environment.", "com.delta.barspeak", "com.delta.barspeak.Full" +
                        "screenActivity"),
                new AppItem("MadLibs", "Madlibs! Fill in words to create\nyour own hilarious spee" +
                        "ch.", "com.delta.deltamadlibs", "com.delta.deltamadlibs.MainActivity"),
                new AppItem("THE BEST APP", "This app is the best yay", "", ""),
                new AppItem("THE BEST APP V2", "This app is even better", "", ""),
                new AppItem("the worst app", "This app sucks", "", "")
        };



        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a DummySectionFragment (defined as a static inner class
            // below) with the page number as its lone argument.
            Fragment fragment = new Fragment();
            if (position == 0) {
                fragment = new AboutMeFragment(person);
                Bundle args = new Bundle();
                fragment.setArguments(args);
            } else if (position == 1) {
                fragment = new AppsFragment(appItems);
                Bundle args = new Bundle();
                fragment.setArguments(args);
            } else if (position == 2) {
                fragment = new ContactFragment(person);
                Bundle args = new Bundle();
                fragment.setArguments(args);
            }
//            Fragment fragment = new DummySectionFragment();
//            Bundle args = new Bundle();
//            args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
//            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A fragment displaying the about me info.
     */
    public static class AboutMeFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
//        public static final String ARG_SECTION_NUMBER = "section_number";

        public static Person person;

        public AboutMeFragment(Person person) {
            this.person = person;

        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_aboutme, container, false);
            TextView nameView = (TextView) rootView.findViewById(R.id.name);
            nameView.setText(person.getPersonFirstName()+ " " + person.getPersonLastName());
            TextView occupationView = (TextView) rootView.findViewById(R.id.occupation);
            occupationView.setText(person.getPersonOccupation());
            TextView experienceView = (TextView) rootView.findViewById(R.id.experience);
            experienceView.setText(String.valueOf(person.getPersonExperience()));
            TextView otherView = (TextView) rootView.findViewById(R.id.experience);
            otherView.setText(person.getPersonOther());
            return rootView;
        }
    }

    /**
     * A fragment that displays the scrolling ListView of apps.
     */
    public static class AppsFragment extends Fragment {

        public AppItem[] appItems;
        private ListView mListView;

        public AppsFragment(AppItem[] appItems) {
            this.appItems = appItems;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_app, container, false);

            // add listview and adapter. here we use getActivity() to get the activity (which is a
            // context).
            AppItemAdapter appItemAdapter = new AppItemAdapter(getActivity(), R.layout.list_row, appItems);

            mListView = (ListView) rootView.findViewById(R.id.listView);
            mListView.setAdapter(appItemAdapter);

            // set up listitems to launch things
            // TODO figure out how to make back button return to this app from different apps.
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");
                    intent.setComponent(new ComponentName(appItems[position].appPackageName, appItems[position].appActivityName));
                    startActivity(intent);
                    // no finish here because we want other apps to go back to this one
                }
            });
            return rootView;
        }
    }

    /**
     * A fragment that displays clickable links that open other apps.
     */
    public static class ContactFragment extends Fragment {

        public Person person;

        public ContactFragment(Person person) {
            this.person = person;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
            TextView phoneNumberView = (TextView) rootView.findViewById(R.id.phone_number);
            phoneNumberView.setText(person.getPersonPhoneNumber());
            phoneNumberView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String uri = "tel:" + person.getPersonPhoneNumber();
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);
                }
            });
            TextView emailAddressView = (TextView) rootView.findViewById(R.id.email_address);
            emailAddressView.setText(person.getPersonEmailAddress());
            emailAddressView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"bradley.kin.fong@gmail.com"});
                    intent.putExtra(android.content.Intent.EXTRA_TEXT, "\n\nSent from the Dossier app.");
                    getActivity().startActivity(Intent.createChooser(intent, "Send mail..."));
                }
            });
            ImageView facebookView = (ImageView) rootView.findViewById(R.id.image_facebook);
            facebookView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    try {
                        getActivity().getPackageManager()
                                .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("fb://profile/" + person.getPersonFacebookId())); //Trys to make intent with FB's URI
                    } catch (Exception e) {
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(person.getPersonFacebookUrl())); //catches and opens a url to the desired page
                    }
                    startActivity(intent);
                }
            });
            ImageView twitterView = (ImageView) rootView.findViewById(R.id.image_twitter);
            twitterView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try
                    {
                        // Check if the Twitter app is installed on the phone.
                        getActivity().getPackageManager().getPackageInfo("com.twitter.android", 0);

                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setClassName("com.twitter.android", "com.twitter.android.ProfileActivity");
                        // Don't forget to put the "L" at the end of the id.
                        intent.putExtra("user_id", person.getPersonTwitterId());
                        startActivity(intent);
                    }
                    catch (Exception e)
                    {
                        // If Twitter app is not installed, start browser.
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(person.getPersonTwitterUrl())));
                    }
                }
            });
            ImageView linkedInView = (ImageView) rootView.findViewById(R.id.image_linkedin);
            linkedInView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(person.getPersonLinkedInUrl()));
                    startActivity(intent);
                }
            });
            return rootView;
        }
    }

}
