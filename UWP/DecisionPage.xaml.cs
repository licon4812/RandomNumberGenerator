using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace RandomNumberGenerator
{
    internal partial class DecisionPage: Page
    {
        public DecisionPage()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            //get text from text box with the name DecisionOptions
            string decisionOptions = DecisionOptions.Text;
            if (decisionOptions == "")
            {
                Decision.Text = "List was Empty";
            }
            else
            {
                //split the text into an array of strings
                string[] options = decisionOptions.Split(new char[] { ';' }, StringSplitOptions.RemoveEmptyEntries);
                //get a random number between 0 and the number of options
                Random random = new Random();
                int randomNumber = random.Next(0, options.Length);
                //display the random option
                Decision.Text = options[randomNumber];
            }
        }

        private void NavigationView_ItemInvoked(Windows.UI.Xaml.Controls.NavigationView sender, Windows.UI.Xaml.Controls.NavigationViewItemInvokedEventArgs args)
        {
            if (args.IsSettingsInvoked)
            {
                // Do something when Settings is selected
            }
            else
            {
                var item = args.InvokedItemContainer as NavigationViewItem;
                if (item.Content.ToString() == "Decision Maker")
                {
                    // Navigate to the DecisionMaker page
                    this.Frame.Navigate(typeof(DecisionPage));
                }
                else if (item.Content.ToString() == "Number Generator")
                {
                    // Navigate to the NumberGenerator page
                    this.Frame.Navigate(typeof(MainPage));
                }
            }
        }
    }
}
