module.exports = async (page, scenario, viewport) => {
  console.log('SCENARIO > ' + scenario.label);

  await page.waitForLoadState('networkidle');

  // TODO: verify removing locators is okay
  await page.waitForTimeout(5000);

  try {
    const cookieButton = page.locator('button:has-text("უარყოფა")');
    await cookieButton.click({ timeout: 5000 });
    await page.waitForTimeout(1000);
  } catch (e) {
    console.log('No cookie prompt found');
  }

  await page.waitForTimeout(2000);
};