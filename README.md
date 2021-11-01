# BaseAlertDialog

# What is Base Alert Dialog ?

We show a warning message (Alert Dialog) to the user in many parts of our applications. You can use this extension instead of creating a separate Alert Dialog for each Activity or Fragment. Thanks to this extension, you can create a Dialog and call it in the Activity or Fragment you want and customize the component you want.

<img width="250" alt="Screen Shot 2021-11-01 at 15 46 46" src="https://user-images.githubusercontent.com/28503591/139675000-d8a92b22-5678-41ae-a73b-265ba2de66c8.png">

# How to use ?

Very simple. We call the showAlertDialog extension on the activity or fragment you want to use. We give the properties of the components of our layout that we created for the dialog in the callback.

For example;

    private var alertDialog: AlertDialog? = null

    alertDialog = showAlertDialog {

            cancelable = false

            setTitle("Title")
            setBody("Body")

            prepareOkayButton("Okay", "#A7DE3D")
            prepareCancelButton("Cancel", "#F77B7B")

            okayClickListener {

                Toast.makeText(applicationContext, "OkayListener", Toast.LENGTH_SHORT).show()
                alertDialog?.dismiss()
            }

            cancelClickListener {

                Toast.makeText(applicationContext, "CancelListener", Toast.LENGTH_SHORT).show()
                alertDialog?.dismiss()
            }
        }

        alertDialog?.show()

You can edit the layout according to your own wishes and define it from the Alert Dialog Helper class. 😊


