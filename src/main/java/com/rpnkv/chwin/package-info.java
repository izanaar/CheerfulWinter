/**
 * Cheerful Winter application consists from 2 modules: study and translate. Respectively, 'translate' subpackage
 * contains translation only functionality, and 'study' - study. Interaction between these modules is not bi-directional.
 * User's translate requests are intercepted by aspect, to be then sued by study module.
 */
package com.rpnkv.chwin;
