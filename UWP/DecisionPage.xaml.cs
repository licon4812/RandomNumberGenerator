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
            if (int.TryParse(MinInput.Text, out int min) && int.TryParse(MaxInput.Text, out int max))
            {
                if (min < max)
                {
                    Random random = new Random();
                    int randomNumber = random.Next(min, max + 1);
                    RandomNumber.Text = randomNumber.ToString();
                }
                else
                {
                    RandomNumber.Text = "Min value must be less than max value";
                }
            }
            else
            {
                RandomNumber.Text = "Invalid input";
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
