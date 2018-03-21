# Sweet Error

## Sweet Designs
<table>
  <tr>
    <td><img src="https://raw.githubusercontent.com/therajanmaurya/Sweet-Error/master/arts/Home.png"></td>
    <td><img src="https://raw.githubusercontent.com/therajanmaurya/Sweet-Error/master/arts/EmptyUI.png"></td>
    <td><img src="https://raw.githubusercontent.com/therajanmaurya/Sweet-Error/master/arts/ErrorUI.png"></td>
  </tr>
</table>
<table>
  <tr>
    <td><img src="https://raw.githubusercontent.com/therajanmaurya/Sweet-Error/master/arts/NoInternetUI.png"></td>
    <td><img src="https://raw.githubusercontent.com/therajanmaurya/Sweet-Error/master/arts/NoInternet.png"></td>
    <td><img src="https://raw.githubusercontent.com/therajanmaurya/Sweet-Error/master/arts/CustomErrorUI.png"></td>
  </tr>
</table>

# APK
[Debug APK](https://github.com/therajanmaurya/Sweet-Error/releases/download/v1.0/SweetError.apk)

Usage
-----

In order to use the library

**1. Gradle dependency** 

  -  Add the following to your project level `build.gradle`:
 
```gradle
allprojects {
	repositories {
		maven { url 'https://dl.bintray.com/therajanmaurya/Sweet-Error/' }
	}
}
```
  -  Add this to your app `build.gradle`:
 
```gradle
dependencies {
	implementation 'com.github.therajanmaurya:Sweet-Error:1.0.0'
}
```

**2. Usage** 

  - Add the Sweet-Error xml layout in the parent view of your project xml layout.

```<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout
    android:id="@+id/cl_sweet"
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_height="match_parent"
    android:layout_width="match_parent">

    <LinearLayout
        android:id="@+id/ll_sweet"
        android:layout_height="match_parent"
        android:layout_width="match_parent"
        android:orientation="vertical">

        .................

    </LinearLayout>

    <include
        layout="@layout/layout_sweet_exception_handler"
        android:id="@+id/layout_error"
        android:visibility="gone"/>

</android.support.design.widget.CoordinatorLayout>
```

  - Initialize the SweetUIErrorHandler in your **Activity** and use it.

```
public class SweetErrorInActivity extends AppCompatActivity {

    private SweetUIErrorHandler sweetUIErrorHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweet_error);
        
        View layoutError = findViewById(R.id.layout_error);
        LinearLayout llSweet = findViewById(R.id.ll_sweet); // It can be any child of your xml like Relativelayout, RecyclerView etc, as we defined in above xml.

        sweetUIErrorHandler = new SweetUIErrorHandler(this, findViewById(android.R.id.content));
       
        // Now you are all set. Whatever error UI you want to show according to condition like
        
        # Empty UI (1.1)
        // Need to pass the feature(s) name that is empty and icon image of the feature that you want to show and if 
        // you have feature of addition then pass the feature name and your child view that you want hide and 
        // layoutError UI to visible. 
         sweetUIErrorHandler.showSweetEmptyUI(getString(R.string.sweets),
                        getString(R.string.sweet), R.drawable.ic_adb_black_24dp,
                        llSweet, layoutError);
        
    }
    
    @OnClick(R.id.btn_try_again)
    void retrySweet() {
        Snackbar.make(findViewById(R.id.cl_sweet), "Loading Sweet ...",
                Snackbar.LENGTH_LONG).show();
    }
```

  - Initialize the SweetUIErrorHandler in your **Fragment** and use it.
  
```
public class SweetErrorInFragment extends Fragment {

    private View rootView;
    private SweetUIErrorHandler sweetUIErrorHandler;
    
    public SweetErrorInFragment() {
    
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_adjournment_list, container, false);
        
        View layoutError = rootView.findViewById(R.id.layout_error);
        LinearLayout llSweet = rootView. findViewById(R.id.ll_sweet); // It can be any child of your xml like Relativelayout, RecyclerView etc, as we defined in above xml.
         
        justiceUIErrorHandler = new JusticeUIErrorHandler(getActivity(), rootView);
        
         // Now you are all set. Whatever error UI you want to show according to condition like
        
        return rootView;
    }
}
```

# Design Inspiration

Self developing projects

# Developers

* [Rajan Maurya](https://github.com/therajanmaurya)

# License

```
Copyright 2018 Rajan Maurya

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```



