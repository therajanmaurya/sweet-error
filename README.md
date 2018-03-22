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
		jcenter()
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

```xml
<?xml version="1.0" encoding="utf-8"?>
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

```java
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
        // layoutError UI to visible. It will handle everything.
         sweetUIErrorHandler.showSweetEmptyUI(getString(R.string.sweets),
                        getString(R.string.sweet), R.drawable.ic_adb_black_24dp,
                        llSweet, layoutError);
			
			
		# Empty UI (1.2)
		// Need to pass the feature(s) name that is empty and icon image of the feature that you want to show
		// and your child view that you want hide and layoutError UI to visible. It will handle everything.
		// See 2nd screenshot above as an example
		 sweetUIErrorHandler.showSweetEmptyUI(getString(R.string.sweets), R.drawable.ic_adb_black_24dp,
				llSweet, layoutError);


		# Error UI (1.1)
		// Need to pass the feature name in which error occured and
		// your child view that you want hide and layoutError UI to visible. It will handle everything.
		sweetUIErrorHandler.showSweetErrorUI(getString(R.string.sweets), llSweet, layoutError);


		# Error UI (1.2)
		// Need to pass the feature name in which error occured and image that you want to show like 
		// bad internet connection image etc.
		// your child view that you want hide and layoutError UI to visible. It will handle everything.
		sweetUIErrorHandler.showSweetErrorUI(getString(R.string.sweets), R.drawable.ic_no_network llSweet, layoutError);


		// Use this button click to refresh UI if any error occured or any Network issue occured.
		Button btnTryAgain = findViewById(R.id.btn_try_again);


		# No Network I UI (1.1)
		// Need to pass your child view that you want hide and layoutError UI to visible. It will handle everything.
		// It will look like above 4th screenshot.
		sweetUIErrorHandler.showSweetNoInternetUI(llSweet, layoutError);


		# Custom Error UI (1.1)
		// Need to pass Image that will show up at the top of title and
		// the title text that will show bottom to the image and subtext that will show in bottom of title text.
		// and your child view that you want hide and layoutError UI to visible. It will handle everything.
		 sweetUIErrorHandler.showSweetCustomErrorUI(getString(R.string.no_sweets_found),
				getString(R.string.come_later_again), R.drawable.ic_adb_black_24dp,
				llSweet, layoutError);	


		# Custom Error UI (1.2)
		// Need to pass Image that will show up at the top of title and subtitle of error message.
		// the title text that will show bottom to the image and there will be no subtext, only image and error text.
		// and your child view that you want hide and layoutError UI to visible. It will handle everything.
		 sweetUIErrorHandler.showSweetCustomErrorUI(getString(R.string.no_sweets_found), R.drawable.ic_adb_black_24dp,
				llSweet, layoutError);	
   	 }
  }
```

  - Initialize the SweetUIErrorHandler in your **Fragment** and use it.
  
```java
public class SweetErrorInFragment extends Fragment {

    private View rootView;
    private SweetUIErrorHandler sweetUIErrorHandler;
    
    public SweetErrorInFragment() {
    
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sweet, container, false);
        
        View layoutError = rootView.findViewById(R.id.layout_error);
        LinearLayout llSweet = rootView.findViewById(R.id.ll_sweet); // It can be any child of your xml like Relativelayout, RecyclerView etc, as we defined in above xml.
         
        sweetUIErrorHandler = new SweetUIErrorHandler(getActivity(), rootView);
        
        // Now you are all set. Whatever error UI you want to show according to condition like
		// you can use rest of things as we are using in above activity.

		// Use this button click to refresh UI if any error occured or any Network issue occured.
		Button btnTryAgain = rootView.findViewById(R.id.btn_try_again);
        
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



